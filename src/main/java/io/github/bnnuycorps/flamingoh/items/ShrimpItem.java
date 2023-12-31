package io.github.bnnuycorps.flamingoh.items;

import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShrimpItem extends Item {

	public ShrimpItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		PlayerEntity player = (PlayerEntity) user;
		StatusEffectInstance effectInstance = player.getStatusEffect(FlamingohRegistry.SHRIMP_STATUS_EFFECT);
		int duration = 600;
		if(effectInstance == null) {
			player.addStatusEffect(new StatusEffectInstance(FlamingohRegistry.SHRIMP_STATUS_EFFECT,duration, 0));
		}
		else {
			int amplifier = effectInstance.getAmplifier();
			if(effectInstance.getAmplifier() < 2) {
				player.addStatusEffect(new StatusEffectInstance(FlamingohRegistry.SHRIMP_STATUS_EFFECT, duration * 2, amplifier + 1));
			}
		}
		return super.finishUsing(stack, world, user);
	}
}
