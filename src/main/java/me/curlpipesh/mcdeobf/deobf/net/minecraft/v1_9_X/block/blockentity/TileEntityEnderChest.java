package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_9_X.block.blockentity;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;

import java.util.List;

/**
 * @author audrey
 * @since 8/25/15.
 */
public class TileEntityEnderChest extends Deobfuscator {
    public TileEntityEnderChest() {
        super("TileEntityEnderChest", "net.minecraft.tileentity");
    }

    @Override
    public boolean deobfuscate(byte[] classData) {
        ClassReader cr = new ClassReader(classData);
        // TODO: Better way etc.
        return cr.getClassName().equals("apy");
    }

    @Override
    public ClassDef getClassDefinition(byte[] classData) {
        return new ClassDef(this);
    }
}
