package me.curlpipesh.mcdeobf.deobf.net.minecraft.world;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.List;

import static me.curlpipesh.mcdeobf.util.AccessHelper.*;

/**
 * @author c
 * @since 8/3/15
 */
public class WorldProvider extends Deobfuscator {
    public WorldProvider() {
        super("WorldProvider");
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean deobfuscate(byte[] classData) {
        ClassReader cr = new ClassReader(classData);
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        int arrc = 0;
        int ps = 0;
        for(FieldNode f : (List<FieldNode>) cn.fields) {
            if(f.desc.contains("[")) {
                if(isPublic(f.access) && isStatic(f.access)) {
                    ++ps;
                }
                ++arrc;
            }
        }

        return arrc == 3 && ps == 1 && isAbstract(cn.access);
    }

    @Override
    public ClassDef getClassDefinition(byte[] classData) {
        return null;
    }
}
