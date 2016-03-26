package com.yi.ziyue.beans;

import java.util.List;

/**
 * Created by Yi on 16/3/13.
 */
public class SearchHotBean {


    /**
     * hotWord : 中国直男癌
     */

    private List<HotWordListEntity> hotWordList;

    public void setHotWordList(List<HotWordListEntity> hotWordList) {
        this.hotWordList = hotWordList;
    }

    public List<HotWordListEntity> getHotWordList() {
        return hotWordList;
    }

    public static class HotWordListEntity {
        private String hotWord;

        public void setHotWord(String hotWord) {
            this.hotWord = hotWord;
        }

        public String getHotWord() {
            return hotWord;
        }
    }
}
