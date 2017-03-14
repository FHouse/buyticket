package org.movie.service.inf;

import org.movie.entity.SeatNumber;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface SeatNumberService extends BaseService{
    public List<SeatNumber> findSeatNumber();
}
