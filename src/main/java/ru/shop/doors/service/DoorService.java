package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.Door;
import ru.shop.doors.repository.DoorRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class DoorService {

    private final DoorRepository doorRepository;

    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public void createDoor(Door doorFromFronted){
        Door door = new Door();
        door.setName(doorFromFronted.getName());
        door.setColor(doorFromFronted.getColor());
        door.setGlazing(doorFromFronted.getGlazing());
        door.setManufacturer(doorFromFronted.getManufacturer());
        door.setMaterial(doorFromFronted.getMaterial());
        door.setType(doorFromFronted.getType());
        door.setPrice(doorFromFronted.getPrice());
        door.setDeleted(false);
        doorRepository.save(door);
    }

    public Door getDoorByName(String name) {
        Door door = doorRepository.getDoorByName(name);
        return door;
    }

    public Door getDoorById(Long id) {
        Door door = doorRepository.getById(id);
        return door;
    }

    public void deleteDoor(Long id) {
        Door door = doorRepository.getById(id);
        door.setDeleted(true);
        doorRepository.save(door);
    }

    public List<Door> findAll() {
        List<Door> allDoors = doorRepository.findAll();
        return allDoors;
    }

    private static Map<String, Integer> getRanks(String[] values) {
        Map<String, Integer> ranks = new HashMap<>();
        int rank = 1;
        for (String value : values) {
            ranks.put(value, rank++);
        }
        return ranks;
    }

    public double spearmanCorrelation(String param) {
        double correlation = 0;
        List<Door> doorList = findAll();
        int sizeOfDoorList = doorList.size();
        double sumOfSquare = 0;
        String[] averageCosts = null;

        switch (param) {
            case "color_id":
                averageCosts = doorRepository.findAverageColor();
                break;
            case "material_id":
                averageCosts = doorRepository.findAverageMaterial();
                break;
            case "manufacturer_id":
                averageCosts = doorRepository.findAverageManufacturer();
                break;
            case "type_id":
                averageCosts = doorRepository.findAverageType();
                break;
            default:
                throw new IllegalArgumentException("Invalid parameter: " + param);
        }

        for (int i = 0; i < sizeOfDoorList; i++) {
            int j = Arrays.asList(averageCosts).indexOf(doorList.get(i).getProperty(param));
            if (j >= 0) {
                sumOfSquare += Math.pow(j + 1, 2);
            }
        }

        correlation = 1 - 6 * (sumOfSquare) / (sizeOfDoorList * (Math.pow(sizeOfDoorList, 2) - 1));
        return correlation;
    }

    public double[][] distanceBetweenValues(String param) {
        Door[] doorList = findAll().toArray(new Door[0]);
        int size = doorList.length;
        double[][] distance = new double[size][size];
        int rangeParam = 0;

        switch (param) {
            case "color_id":
                rangeParam = doorRepository.getMaxColor() - doorRepository.getMinColor();
                break;
            case "material_id":
                rangeParam = doorRepository.getMaxMaterial() - doorRepository.getMinMaterial();
                break;
            case "manufacturer_id":
            case "type_id":
                if (param.equals("manufacturer_id")) {
                    rangeParam = doorRepository.getMaxManufacturer() - doorRepository.getMinManufacturer();
                } else {
                    rangeParam = doorRepository.getMaxType() - doorRepository.getMinType();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid parameter: " + param);
        }

        for (int i = 0; i < size; i++) {
            Door door1 = doorList[i];
            for (int j = i; j < size; j++) {
                Door door2 = doorList[j];
                BigDecimal diff = BigDecimal.ZERO;
                switch (param) {
                    case "color_id":
                        diff = door1.getColor().subtract(door2.getColor()).abs();
                        break;
                    case "material_id":
                        diff = door1.getMaterial().subtract(door2.getMaterial()).abs();
                        break;
                    case "manufacturer_id":
                    case "type_id":
                        diff = param.equals("manufacturer_id") ? door1.getManufacturer().subtract(door2.getManufacturer()).abs() : door1.getType().subtract(door2.getType()).abs();
                        break;
                }
                distance[i][j] = distance[j][i] = diff.divide(BigDecimal.valueOf(rangeParam), 2, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return distance;
    }

    public List<Door> getSimilar(int id, int n) {
        Door mainDoor = doorRepository.findById(id);
        double[] distance = distanceBetweenDoors(id);

        List<Door> similarDoors = doorRepository.findAll()
                .stream()
                .filter(door -> !door.equals(mainDoor))
                .sorted(Comparator.comparingDouble(door -> distance[Math.toIntExact(door.getId())]))
                .limit(n)
                .collect(Collectors.toList());

        return similarDoors;
    }

    public double[] distanceBetweenDoors(long id) {
        double[] colorDistance = distanceBetweenValues("color_id")[(int) (id - 1)];
        double[] manufacturerDistance = distanceBetweenValues("manufacturer_id")[(int) (id - 1)];
        double colorCorrelation = spearmanCorrelation("color_id");
        double manufacturerCorrelation = spearmanCorrelation("manufacturer_id");

        return IntStream.range(0, colorDistance.length)
                .mapToDouble(i -> colorCorrelation * colorDistance[i] + manufacturerCorrelation * manufacturerDistance[i])
                .toArray();
    }

    public ArrayList<Door> findSimilarDoors(double[] distance, ArrayList<Door> doors, int count) {
        ArrayList<Door> similarDoors = new ArrayList();
        long[] indexes = LongStream.rangeClosed(1, distance.length).toArray();
        for (int i = distance.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (distance[j] >= distance[j + 1]) {
                    swap(distance, j, j+1);
                    swap(indexes, j, j+1);
                }
            }
        }
        for (long index : indexes) {
            if (similarDoors.size() >= count) {
                break;
            }
            doors.stream().filter(d -> d.getId() == index).findFirst().ifPresent(similarDoors::add);
        }
        return similarDoors;
    }
    private void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
