package com.sucy.skill.dynamic.mechanic;

import com.sucy.skill.api.util.Buff;
import com.sucy.skill.api.util.BuffManager;
import com.sucy.skill.dynamic.EffectComponent;
import org.bukkit.entity.LivingEntity;

import java.util.List;

/**
 * Applies a flag to each target
 */
public class DefenseBuffMechanic extends EffectComponent
{
    private static final String TYPE    = "type";
    private static final String VALUE   = "value";
    private static final String SECONDS = "seconds";

    /**
     * Executes the component
     *
     * @param caster  caster of the skill
     * @param level   level of the skill
     * @param targets targets to apply to
     *
     * @return true if applied to something, false otherwise
     */
    @Override
    public boolean execute(final LivingEntity caster, final int level, final List<LivingEntity> targets)
    {
        if (targets.size() == 0)
        {
            return false;
        }

        boolean percent = settings.getString(TYPE, "flat").toLowerCase().equals("percent");
        double value = settings.getAttr(VALUE, level, 1.0);
        double seconds = settings.getAttr(SECONDS, level, 3.0);
        int ticks = (int) (seconds * 20);
        for (LivingEntity target : targets)
        {
            BuffManager.addDefenseBuff(target, new Buff(value, percent), ticks);
        }
        return targets.size() > 0;
    }
}
