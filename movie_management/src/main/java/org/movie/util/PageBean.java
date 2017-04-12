package org.movie.util;

import java.util.List;

/**
 * 分页类
 * Created by Wkz on 2017/4/12.
 */
public class PageBean {

    private int maxResult = 10;
    private int pageNum = 1;
    private int rowCount = 0;
    private int pageCount = 0;
    private List<?> list;

    public int getFirstResult(){
        return (pageNum - 1) * this.maxResult;
    }

    public int getMaxResult() {
        return maxResult;
    }
    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = (pageNum == 0) ? 1 : pageNum;
    }

    public int getRowCount() {
        return rowCount;
    }
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
        this.pageCount = (rowCount % maxResult == 0) ? (rowCount/maxResult) : (rowCount/maxResult + 1);
    }

    public int getPageCount(){
        return this.pageCount;
    }

    public List<?> getList() {
        return list;
    }
    public void setList(List<?> list) {
        this.list = list;
    }
}
