package net.itjsz.shirojwt.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenggang
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResponseBean<T> implements Serializable {

  private static final long serialVersionUID = 6887389993060457824L;
  /**
   * 返回数据内容
   */
  @ApiModelProperty(value="返回数据内容")
  private List<T> content;
  /**
   * 总条目数
   */
  @ApiModelProperty(value="总条目数")
  private long totalElements;
  /**
   * 总页数
   */
  @ApiModelProperty(value="总页数")
  private int totalPages;
  /**
   * 是否是最后一页
   */
  @ApiModelProperty(value="是否是最后一页")
  private boolean last;
  /**
   * 当前页
   */
  @ApiModelProperty(value="当前页")
  private int number;
  /**
   * 当前页的条目数
   */
  @ApiModelProperty(value="实际返回条目数")
  private int size;
  @ApiModelProperty(value="预计返回条数")
  private int numberOfElements;
  /**
   * 是否是第一页
   */
  @ApiModelProperty(value="是否是第一页")
  private boolean first;

  public PageResponseBean() {
  }

  public PageResponseBean(PageRequestBean bean, Integer count) {
	  this.totalElements=count;
	  this.totalPages=(int) Math.ceil(count.doubleValue()/bean.getPageSize());
      this.last = totalPages == bean.getPage();
      this.first = bean.getPage() == 1;
	  this.number = bean.getPage();
	  this.numberOfElements = bean.getPageSize();
  }

}
