package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import net.minecraft.util.Identifier;

public class ImageManager {
    public static class CalculateUV {
        private int height;
        private int width;
        public int u1;
        public int v1;
        public int u2;
        public int v2;

        public CalculateUV(int width, int height, int mH, int mV, int sH, int sV) {
            this.height = height;
            this.width = width;
            this.u1 = (mH / this.width);
            this.v1 = (mV / this.height);
            this.u2 = (sH / this.width);
            this.v2 = (sV / this.height);
        }
    }

    public static Identifier getSprite(String path) {
        return new Identifier(QuestnSkills.MOD_ID, path);
    }
}
