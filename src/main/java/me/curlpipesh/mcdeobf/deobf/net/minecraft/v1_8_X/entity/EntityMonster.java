package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_8_X.entity;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;

import java.util.List;

/**
 * @author audrey
 * @since 8/24/15.
 */
public class EntityMonster extends Deobfuscator {
    public EntityMonster() {
        super("EntityMob");
    }

    @Override
    public boolean deobfuscate(byte[] classData) {
        List<String> constantPool = dumpConstantPoolStrings(new ClassReader(classData));
        return constantPool.contains("game.hostile.swim") && constantPool.contains("game.hostile.hurt")
                && constantPool.contains("game.hostile.hurt.fall.big");
    }

    @Override
    public ClassDef getClassDefinition(byte[] classData) {
        return null;
    }
}
