package tiku.工作.楼宇卫视.关于引用的问题;

import java.util.List;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-23
 **/
public class Page<T> {

    protected int pageNum;
    protected int pageSize;
    protected String orderBy;
    protected boolean countTotal;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isCountTotal() {
        return countTotal;
    }

    public void setCountTotal(boolean countTotal) {
        this.countTotal = countTotal;
    }

    List<T> result = null;
    long totalLength = 0L;


    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalLength() {
        return this.totalLength;
    }

    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }

}
