package org.movie.service.impl;

import org.movie.dao.inf.SeatNumberDao;
import org.movie.entity.SeatNumber;
import org.movie.service.inf.SeatNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "SeatNumberService" )
public class SeatNumberServiceImpl extends BaseServiceImpl implements SeatNumberService{
    private SeatNumberDao dao;
    @Override
    public List<SeatNumber> findSeatNumber() {
        return dao.findSeatNumber();
    }
}
