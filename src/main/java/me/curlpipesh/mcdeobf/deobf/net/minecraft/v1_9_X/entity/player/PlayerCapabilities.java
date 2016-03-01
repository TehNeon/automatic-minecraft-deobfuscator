package me.curlpipesh.mcdeobf.deobf.net.minecraft.v1_9_X.entity.player;

import me.curlpipesh.mcdeobf.deobf.ClassDef;
import me.curlpipesh.mcdeobf.deobf.Deobfuscator;
import me.curlpipesh.mcdeobf.util.AccessHelper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

/**
 * Created by TehNeon on 2016-02-29.
 */
public class PlayerCapabilities extends Deobfuscator {

    public PlayerCapabilities() {
        super("PlayerCapabilities", DeobfuscatorPriority.HIGH);
    }

    @Override
    public boolean deobfuscate(byte[] classData) {
        List<String> constantPool = dumpConstantPoolStrings(new ClassReader(classData));
        return constantPool.contains("invulnerable") && constantPool.contains("flying")
                && constantPool.contains("mayfly") && constantPool.contains("instabuild");
    }

    @Override
    @SuppressWarnings("unchecked")
    public ClassDef getClassDefinition(byte[] classData) {
        final ClassDef def = new ClassDef(this);

        final ClassReader cr = new ClassReader(classData);
        final ClassNode cn = new ClassNode();
        cr.accept(cn, 0);

        def.addField("disableDamage", ((List<FieldNode>) cn.fields).get(0).name);
        def.addField("isFlying", ((List<FieldNode>) cn.fields).get(1).name);
        def.addField("allowFlying", ((List<FieldNode>) cn.fields).get(2).name);
        def.addField("isCreativeMode", ((List<FieldNode>) cn.fields).get(3).name);
        def.addField("allowEdit", ((List<FieldNode>) cn.fields).get(4).name);
        def.addField("flySpeed", ((List<FieldNode>) cn.fields).get(5).name);
        def.addField("walkSpeed", ((List<FieldNode>) cn.fields).get(6).name);

        int methodsFound = -1;
        for (MethodNode m : (List<MethodNode>) cn.methods) {
            if (AccessHelper.isPublic(m.access)) {
                methodsFound++;

                switch (methodsFound) {
                    case 1:
                        def.addMethod("writeCapabilitiesToNBT", m);
                        break;
                    case 2:
                        def.addMethod("readCapabilitiesFromNBT", m);
                        break;
                    case 3:
                        def.addMethod("getFlySpeed", m);
                        break;
                    case 4:
                        def.addMethod("setFlySpeed", m);
                        break;
                    case 5:
                        def.addMethod("getWalkSpeed", m);
                        break;
                    case 6:
                        def.addMethod("setPlayerWalkSpeed", m);
                        break;
                }
            }
        }


        return def;
    }
}
