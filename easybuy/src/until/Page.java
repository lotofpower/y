package cnm.itcast.easybuy.util;

import java.util.List;

/**
 * Created by Admin on 2019/12/9.
 */
public class Page<T> {
    private Integer pageNo=1;//当前页的页码
    private Integer pageSize=5;//每页显示的记录数
    private  Integer rowCount;//总记录数
    private Integer pageCount;//总页数
    private List<T> date;//存储查询到的分页片段记录

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getRowCount() {
        return rowCount;
    }
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
    public Integer getPageCount() {
        if(rowCount % pageSize==0){
            this.pageCount=rowCount/pageSize;
        }else {
            this.pageCount=rowCount/pageSize+1;
        }
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    //获取当前页查询的片段数据中，第一条记录的下标
    public Integer getFirstRecord(){
        return  (pageNo-1)*pageSize;
    }
}
