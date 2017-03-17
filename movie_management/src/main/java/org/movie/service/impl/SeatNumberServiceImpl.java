package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.SeatNumberDao;
import org.movie.entity.SeatNumber;
import org.movie.service.inf.SeatNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "seatNumberService" )
@Transactional
public class SeatNumberServiceImpl implements SeatNumberService{
    //注入dao
    @Autowired
    @Qualifier("seatNumberDao")
    private SeatNumberDao dao;
}
