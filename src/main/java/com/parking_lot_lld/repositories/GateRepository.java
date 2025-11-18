package com.parking_lot_lld.repositories;

import com.parking_lot_lld.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    //Optional -> to avoid nullPointerException
    private Map<Long, Gate> gateMap = new HashMap<>();
    public Optional<Gate> findGateById(Long gateId) {
        if(gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }
}
