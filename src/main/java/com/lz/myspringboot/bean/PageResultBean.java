package com.lz.myspringboot.bean;

import com.github.pagehelper.PageInfo;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LZ
 * @Date: 2018/11/24 12: 17
 */
@Getter
public class PageResultBean<T> extends ResultBean<T> implements Serializable {

    // 总记录数
    private long totalRecord;

    // 总页数
    private Integer pageCount;

    // 当前页码
    private Integer pageNumber;

    // 当前页的记录数量
    private Integer pageSize;

    private List<?> data;

    public PageResultBean(List<?> data) {
        PageInfo<?> pageInfo = new PageInfo<>(data);
        this.setPageNumber(pageInfo.getPageNum())
                .setPageSize(pageInfo.getPageSize())
                .setPageCount(pageInfo.getPages())
                .setTotalRecord(pageInfo.getTotal())
                .setData(data);
    }

    public PageResultBean() {
        super();
    }

    private PageResultBean setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        return this;
    }

    private PageResultBean setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public PageResultBean setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public PageResultBean setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber == null ? ConstantBean.PAGE_NUMBER_DEFAULT : pageNumber;
    }

    public Integer getPageSize() {
        return pageSize == null ? ConstantBean.PAGE_SIZE_DEFAULT : pageSize;
    }

    @Override
    public PageResultBean setCode(int code) {
        super.setCode(code);
        return this;
    }

    @Override
    public PageResultBean setData(T data) {
        super.setData(data);
        return this;
    }

    private void setData(List data) {
        this.data = data;
    }

    public T getData() {
        return (T) data;
    }
}
