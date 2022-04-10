package com.rogerserra.listener;

import com.rogerserra.businesslogic.EnergyManager;
import com.rogerserra.model.Machine;
import com.rogerserra.model.OpengateRequest;
import com.rogerserra.model.Statistics;
import com.rogerserra.repository.StatisticsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OpengateRequestListener {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Autowired
    EnergyManager energyManager;

    @RabbitListener(queues = "request_queue")
    public void listener(OpengateRequest opengateRequest){
        System.out.println("Message from QUEUE receiced!");
    }

    private void saveStatistics(OpengateRequest opengateRequest){
        try {
            List<Machine> machineList = new ArrayList<>(opengateRequest.getOperation().getResponse()
                    .getMachines());
            Statistics statistics = energyManager.calculateStatistics(machineList);
            statisticsRepository.save(statistics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
