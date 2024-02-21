package com.example.examplemod.lodestone_effects;

import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.particle.type.LodestoneParticleType;

public class ModParticles {
    public static RegistryObject<LodestoneParticleType> WEIRD_PARTICLE;

    static {
        WEIRD_PARTICLE = LodestoneParticleRegistry.PARTICLES.register("weird_particle", LodestoneParticleType::new);
    }
}
