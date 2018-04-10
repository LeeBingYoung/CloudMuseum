package com.YunMuseum.utils;
//贝叶斯平均算法点赞权重计算
public class WR {
    public float WR(float Rating, int votes, int min, float average, int max){
        float WR = ( votes * Rating + min * average ) / ( votes + min );
        float WRScore = WR / max;
        return WRScore;
    }
}
