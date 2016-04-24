package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_9_X.entity;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;

/**
 * @author audrey
 * @since 8/24/15.
 */
public class EntityMob extends Deobfuscator {
    public EntityMob() {
        super("EntityMob", "net.minecraft.entity.monster");
    }

    @Override
    public boolean deobfuscate(byte[] classData) {
        // TODO: Better method of identification
        return new ClassReader(classData).getClassName().startsWith("yp");
    }

    @Override
    public ClassDef getClassDefinition(byte[] classData) {
        return null;
    }
}
