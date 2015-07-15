package cn.uncode.schedule.filter;

import cn.uncode.schedule.zk.ZKManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Created by qqr on 15/7/15.
 */
public class ZKFilter extends Filter {

    protected static final transient Logger LOGGER = LoggerFactory.getLogger(ZKFilter.class);

    private String filterZkPath;

    private String data;

    public void setFilterZkPath(String filterZkPath) {
        this.filterZkPath = filterZkPath;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean execute(ZKManager zkManager) {
        Assert.notNull(this.filterZkPath, "filterZkPath can not be null");
        Assert.notNull(this.data,"data can not be null");
        try {
            byte [] byteData = zkManager.getZooKeeper().getData(this.filterZkPath,false,null);
            if(byteData != null && this.data.equals(new String(byteData))){
                LOGGER.debug(this.filterZkPath+":"+data+" is exist ,task not run !");
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }
}
