package com.parking_lot_lld.factory;

import com.parking_lot_lld.models.SpotAssignmentStrategyType;
import com.parking_lot_lld.strategies.CheapestSpotAssignmentStrategy;
import com.parking_lot_lld.strategies.NearestSpotAssignmentStrategy;
import com.parking_lot_lld.strategies.RandomAssignmentStrategy;
import com.parking_lot_lld.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {

        if (spotAssignmentStrategyType == SpotAssignmentStrategyType.NEAREST) {
            return new NearestSpotAssignmentStrategy();
        } else if (spotAssignmentStrategyType == SpotAssignmentStrategyType.CHEAPEST) {
            return new CheapestSpotAssignmentStrategy();
        }
        return new RandomAssignmentStrategy();
    }
}
