package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_9_X.entity;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;

import java.util.List;

/**
 * @author audrey
 * @since 12/8/15.
 */
public class DataWatcher extends Deobfuscator {
    public DataWatcher() {
        super("DataWatcher", "net.minecraft.entity");
    }

    @Override
    public boolean deobfuscate(final byte[] classData) {
        List<String> constantPool = dumpConstantPoolStrings(new ClassReader(classData));
        return constantPool.contains("Data value id is too big with ")
                && constantPool.contains("Getting synched entity data");
    }

    @Override
    public ClassDef getClassDefinition(final byte[] classData) {
        return null;
    }
}
