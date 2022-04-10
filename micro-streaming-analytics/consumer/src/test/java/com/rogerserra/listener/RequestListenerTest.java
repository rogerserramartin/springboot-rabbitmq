package com.rogerserra.listener;

import com.rogerserra.model.OpengateRequest;
import com.rogerserra.repository.StatisticsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RequestListenerTest {

    @Mock
    StatisticsRepository statisticsRepository;
    private AutoCloseable autoCloseable;

    @InjectMocks
    OpengateRequestListener underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close(); //cerramos el recurso despues del test
    }

    @Test
    void canRegisterRequest(){
        OpengateRequest opengateRequest = new OpengateRequest();
    }
}
