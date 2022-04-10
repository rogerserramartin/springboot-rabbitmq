package com.rogerserra.businesslogic;

import com.rogerserra.model.Machine;
import com.rogerserra.model.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnergyManager {

    public EnergyManager() {
    }

    public Statistics calculateStatistics(List<Machine> machineList) {
        double mean = 0d;
        List<Double> energyConsumptionList = new ArrayList<>();
        for (Machine machine : machineList) {
            energyConsumptionList.add(machine.getEnergyConsumption());
            mean += machine.getEnergyConsumption(); // BigDecimals inside loops work a bit different as we can see
        }
        mean = mean / machineList.size();
        int medianValuePosition = (Integer) (energyConsumptionList.size() / 2); // whole number
        int firstQuartilePosition = (Integer) (energyConsumptionList.size() / 4);
        int thirdQuartilePosition = energyConsumptionList.size() - firstQuartilePosition;
        Double median = energyConsumptionList.get(medianValuePosition);
        Double mode = calculateMode(energyConsumptionList);
        Double standardDeviation = calculateStandardDeviation(energyConsumptionList, mean);
        ArrayList<Double> quartiles = new ArrayList<>(
                Arrays.asList(
                        energyConsumptionList.get(firstQuartilePosition),
                        energyConsumptionList.get(medianValuePosition),
                        energyConsumptionList.get(thirdQuartilePosition),
                        energyConsumptionList.get(energyConsumptionList.size() - 1)
                )
        );
        Double minimum = Collections.min(energyConsumptionList);
        Double maximum = Collections.max(energyConsumptionList);

        return Statistics.builder()
                .mean(mean)
                .median(median)
                .mode(mode)
                .standardDeviation(standardDeviation)
                .quartiles(quartiles)
                .minimumValue(minimum)
                .maximumValue(maximum)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public Double calculateStandardDeviation(List<Double> energyConsumptionList, double mean) {
        double standardDeviation = 0d;
        for(Double energy : energyConsumptionList){
            standardDeviation += Math.pow((energy - mean), 2);
        }

        double squareRoot = standardDeviation / energyConsumptionList.size();
        return Math.sqrt(squareRoot);
    }

    public Double calculateMode(List<Double> energyConsumptionList) {
        // given an array, we'll loop N times, where N is the arrayList size. This way, we can obtain the mode
        // example: 1,4,6,1,4,4 -> in 1st iteration 1 appears 2 times, but in 2nd 4 appears 3, so 1 is replaced by 4 as the new mode
        Double maxValue = 0d;
        int maxCount = 0;

        for (int i = 0; i < energyConsumptionList.size(); i++) {
            int count = 0;
            for (Double energy : energyConsumptionList) {
                if (energy.equals(energyConsumptionList.get(i))) {
                    count++;
                }
                // replace newer most common energy consumption number
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = energyConsumptionList.get(i);
                }
            }
        }
        return maxValue; // aka mode
    }
}
