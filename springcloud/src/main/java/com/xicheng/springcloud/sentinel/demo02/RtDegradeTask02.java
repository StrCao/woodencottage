package com.xicheng.springcloud.sentinel.demo02;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xichengxml
 * @date 2019/1/18 14:55
 */
public class RtDegradeTask02 implements Callable<String>{

    private static final Logger LOGGER = LoggerFactory.getLogger(RtDegradeTask02.class);

    private static Map<String, String> keyMap = new ConcurrentHashMap<>();

    private String key;
    private int timeout;

    public RtDegradeTask02() {
    }

    public RtDegradeTask02(String key, int timeout) {
        this.key = key;
        this.timeout = timeout;
    }

    @Override
    public String call() throws Exception {
        initDegradeRule();
        Entry entry = null;
        long runTime = 0L;
        try {
            entry = SphU.entry(key);
            long start = System.currentTimeMillis();
            bizCode();
            runTime = System.currentTimeMillis() - start;
        } catch (Throwable t) {
            if (BlockException.isBlockException(t)) {
                Tracer.trace(t);
            }
            LOGGER.info("This task is timeout：" + key + "--runTime:" + runTime);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    /**
     * 平均响应时间 (DEGRADE_GRADE_RT)：当资源的平均响应时间超过阈值（DegradeRule 中的 count，以 ms 为单位）之后，资源进入准降级状态。
     * 接下来如果持续进入 5 个请求，它们的 RT 都持续超过这个阈值，那么在接下的时间窗口（DegradeRule 中的timeWindow，以 s 为单位）
     * 之内，对这个方法的调用都会自动地返回（抛出 DegradeException）
     */
    private void initDegradeRule() {
        synchronized (RtDegradeTask02.class) {
            if (keyMap.containsKey(key)) {
                return;
            }
            DegradeRule rule = new DegradeRule();
            rule.setResource(key);
            // set threshold rt, 10 ms
            rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
            rule.setCount(300);
            rule.setTimeWindow(10);
            List<DegradeRule> rules = DegradeRuleManager.getRules();
            rules.add(rule);
            DegradeRuleManager.loadRules(rules);
            keyMap.put(key, key);
        }
    }

    private void bizCode() {
        long start = System.currentTimeMillis();
        long runTime = 0L;
        try {
            Thread.sleep(timeout);
            runTime = System.currentTimeMillis() - start;
            LOGGER.info("This task is success：" + key + "--keyMap size:" + keyMap.size() + "--runTime:" + runTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
