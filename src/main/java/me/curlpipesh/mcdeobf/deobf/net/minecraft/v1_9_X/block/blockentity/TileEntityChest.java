package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_9_X.block.blockentity;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;

import java.util.List;

/**
 * @author audrey
 * @since 8/25/15.
 */
public class TileEntityChest extends Deobfuscator {
    public TileEntityChest() {
        super("TileEntityChest", "net.minecraft.tileentity");
    }

    @Override
    public boolean deobfuscate(byte[] classData) {
        List<String> constantPool = dumpConstantPoolStrings(new ClassReader(classData));
        return constantPool.contains("container.chest") && constantPool.contains("minecraft:chest");
    }

    @Override
    public ClassDef getClassDefinition(byte[] classData) {
        return new ClassDef(this);
    }
}
