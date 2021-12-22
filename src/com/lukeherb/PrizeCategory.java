package com.lukeherb;

public class PrizeCategory {
    public PrizeType calculatePrize(int earnedTickets) {
        if (earnedTickets >= 30)
            return PrizeType.SMALL_PRIZE;
        else if (earnedTickets >= 20)
            return PrizeType.MEDIUM_PRIZE;
        else if (earnedTickets >= 10)
            return PrizeType.SMALL_PRIZE;
        else
            return PrizeType.NO_PRIZE;

    }
}
