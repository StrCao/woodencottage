package com.xicheng.springcloud.sentinel.demo02;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/18 17:19
 */
public class RtDegradeManager {

    private static List<DegradeRule> degradeRules;

    public static List<DegradeRule> getDegradeRules() {
        return degradeRules;
    }

    public static void setDegradeRules(List<DegradeRule> degradeRules) {
        RtDegradeManager.degradeRules = degradeRules;
    }

    public static void loadRules(List<DegradeRule> degradeRules) {
        DegradeRuleManager.loadRules(degradeRules);
    }
}
