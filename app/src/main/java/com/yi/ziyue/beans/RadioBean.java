package com.yi.ziyue.beans;

import java.util.List;

/**
 * Created by Yi on 16/3/17.
 */
public class RadioBean {


    /**
     * tList : [{"template":"normal1","topicid":"00960CTM","hasCover":false,"alias":"yuleBigBangyuyin","subnum":"92","recommendOrder":0,"isNew":0,"img":"null","isHot":0,"hasIcon":true,"cid":"C1420525588210","recommend":"0","headLine":false,"playCount":18992,"color":"","bannerOrder":0,"tname":"娱乐Big Bang","ename":"yuleBigBangyuyin1","radio":{"postid":"BICE75JN00964KM4","hasCover":false,"hasHead":0,"replyCount":0,"ltitle":"娱乐BigBang:逞强的中国动画","hasImg":0,"digest":"　　　　　　　　　　　　　　　　　　　　","hasIcon":true,"docid":"BICE75JN00964KM4","title":"娱乐BigBang:逞强的中国动画","TAGS":"音频","order":2,"priority":60,"lmodify":"2016-03-17 16:08:14","boardid":"3g_bbs","TAG":"音频","url_3w":"http://help.3g.163.com/16/0317/16/BICE75JN00964KM4.html","template":"normal1","votecount":0,"alias":"yuleBigBangyuyin","cid":"C1420525588210","url":"http://3g.163.com/ntes/16/0317/16/BICE75JN00964KM4.html","size":"","hasAD":0,"source":"娱乐BigBang语音版","ename":"yuleBigBangyuyin1","tname":"娱乐Big Bang","subtitle":"","imgsrc":"http://img5.cache.netease.com/3g/2016/3/17/20160317154804f120a.jpg","ptime":"2016-03-17 16:07:23"},"showType":"comment","tid":"T1420624664001"},{"template":"normal1","topicid":"00960CQK","hasCover":false,"alias":"qingsongyikeyuyinban","subnum":"95","recommendOrder":0,"isNew":0,"img":"null","isHot":0,"hasIcon":true,"cid":"C1420525588210","recommend":"0","headLine":false,"playCount":19618,"color":"","bannerOrder":0,"tname":"轻松一刻语音版","ename":"qingsongyikeyuyinban1","radio":{"postid":"BIBFMP7700964KLQ","hasCover":false,"hasHead":0,"replyCount":5,"ltitle":"轻松一刻语音版(3月17日）","hasImg":0,"digest":"　　　　　　　　　　　　　　　　　　　　","hasIcon":true,"docid":"BIBFMP7700964KLQ","title":"有一种企业死亡叫\"成龙代言\"","TAGS":"语音","order":2,"priority":70,"lmodify":"2016-03-17 08:39:40","boardid":"3g_bbs","TAG":"语音","url_3w":"http://help.3g.163.com/16/0317/07/BIBFMP7700964KLQ.html","template":"normal1","votecount":0,"alias":"qingsongyikeyuyinban","cid":"C1420525588210","url":"http://3g.163.com/ntes/16/0317/07/BIBFMP7700964KLQ.html","hasAD":0,"source":"轻松一刻工作室","ename":"qingsongyikeyuyinban1","tname":"轻松一刻语音版","subtitle":"","imgsrc":"http://img2.cache.netease.com/3g/2016/3/17/2016031707144363e08.jpg","ptime":"2016-03-17 07:14:08"},"showType":"comment","tid":"T1420624664030"},{"template":"normal1","topicid":"00300MG1","hasCover":false,"alias":"gentiefengshenbang","subnum":"68","recommendOrder":0,"isNew":0,"img":"null","isHot":0,"hasIcon":true,"cid":"C1420525588210","recommend":"0","headLine":false,"playCount":14035,"color":"","bannerOrder":0,"tname":"跟贴封神榜","ename":"gentiefengshenbang1","radio":{"postid":"BH144H1I00304IQO","hasCover":false,"hasHead":0,"replyCount":146,"pixel":"550*400","ltitle":"","hasImg":0,"digest":"房价上涨，多地市民通宵排队抢购，网友：接着忽悠！","hasIcon":true,"docid":"BH144H1I00304IQO","title":"封神榜:奥斯卡应颁给中国房托","TAGS":"语音","order":2,"priority":60,"lmodify":"2016-02-29 20:24:33","boardid":"tie_bbs","TAG":"语音","url_3w":"http://help.3g.163.com/16/0229/20/BH144H1I00304IQO.html","template":"normal1","votecount":101,"alias":"gentiefengshenbang","cid":"C1420525588210","url":"http://3g.163.com/ntes/16/0229/20/BH144H1I00304IQO.html","hasAD":0,"source":"网易跟贴","ename":"gentiefengshenbang1","tname":"跟贴封神榜","subtitle":"","imgsrc":"http://img1.cache.netease.com/tie/2016/2/29/20160229202332c6dbb.jpg","ptime":"2016-02-29 20:23:50"},"showType":"comment","tid":"T1420624664140"}]
     * cid : C1420525588210
     * cname : 原创
     */

    private List<CListEntity> cList;
    private List<?> top;

    public void setCList(List<CListEntity> cList) {
        this.cList = cList;
    }

    public void setTop(List<?> top) {
        this.top = top;
    }

    public List<CListEntity> getCList() {
        return cList;
    }

    public List<?> getTop() {
        return top;
    }

    public static class CListEntity {
        private String cid;
        private String cname;
        /**
         * template : normal1
         * topicid : 00960CTM
         * hasCover : false
         * alias : yuleBigBangyuyin
         * subnum : 92
         * recommendOrder : 0
         * isNew : 0
         * img : null
         * isHot : 0
         * hasIcon : true
         * cid : C1420525588210
         * recommend : 0
         * headLine : false
         * playCount : 18992
         * color :
         * bannerOrder : 0
         * tname : 娱乐Big Bang
         * ename : yuleBigBangyuyin1
         * radio : {"postid":"BICE75JN00964KM4","hasCover":false,"hasHead":0,"replyCount":0,"ltitle":"娱乐BigBang:逞强的中国动画","hasImg":0,"digest":"　　　　　　　　　　　　　　　　　　　　","hasIcon":true,"docid":"BICE75JN00964KM4","title":"娱乐BigBang:逞强的中国动画","TAGS":"音频","order":2,"priority":60,"lmodify":"2016-03-17 16:08:14","boardid":"3g_bbs","TAG":"音频","url_3w":"http://help.3g.163.com/16/0317/16/BICE75JN00964KM4.html","template":"normal1","votecount":0,"alias":"yuleBigBangyuyin","cid":"C1420525588210","url":"http://3g.163.com/ntes/16/0317/16/BICE75JN00964KM4.html","size":"","hasAD":0,"source":"娱乐BigBang语音版","ename":"yuleBigBangyuyin1","tname":"娱乐Big Bang","subtitle":"","imgsrc":"http://img5.cache.netease.com/3g/2016/3/17/20160317154804f120a.jpg","ptime":"2016-03-17 16:07:23"}
         * showType : comment
         * tid : T1420624664001
         */

        private List<TListEntity> tList;

        public void setCid(String cid) {
            this.cid = cid;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public void setTList(List<TListEntity> tList) {
            this.tList = tList;
        }

        public String getCid() {
            return cid;
        }

        public String getCname() {
            return cname;
        }

        public List<TListEntity> getTList() {
            return tList;
        }

        public static class TListEntity {
            private String template;
            private String topicid;
            private boolean hasCover;
            private String alias;
            private String subnum;
            private int recommendOrder;
            private int isNew;
            private String img;
            private int isHot;
            private boolean hasIcon;
            private String cid;
            private String recommend;
            private boolean headLine;
            private int playCount;
            private String color;
            private int bannerOrder;
            private String tname;
            private String ename;
            /**
             * postid : BICE75JN00964KM4
             * hasCover : false
             * hasHead : 0
             * replyCount : 0
             * ltitle : 娱乐BigBang:逞强的中国动画
             * hasImg : 0
             * digest :
             * hasIcon : true
             * docid : BICE75JN00964KM4
             * title : 娱乐BigBang:逞强的中国动画
             * TAGS : 音频
             * order : 2
             * priority : 60
             * lmodify : 2016-03-17 16:08:14
             * boardid : 3g_bbs
             * TAG : 音频
             * url_3w : http://help.3g.163.com/16/0317/16/BICE75JN00964KM4.html
             * template : normal1
             * votecount : 0
             * alias : yuleBigBangyuyin
             * cid : C1420525588210
             * url : http://3g.163.com/ntes/16/0317/16/BICE75JN00964KM4.html
             * size :
             * hasAD : 0
             * source : 娱乐BigBang语音版
             * ename : yuleBigBangyuyin1
             * tname : 娱乐Big Bang
             * subtitle :
             * imgsrc : http://img5.cache.netease.com/3g/2016/3/17/20160317154804f120a.jpg
             * ptime : 2016-03-17 16:07:23
             */

            private RadioEntity radio;
            private String showType;
            private String tid;

            public void setTemplate(String template) {
                this.template = template;
            }

            public void setTopicid(String topicid) {
                this.topicid = topicid;
            }

            public void setHasCover(boolean hasCover) {
                this.hasCover = hasCover;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public void setSubnum(String subnum) {
                this.subnum = subnum;
            }

            public void setRecommendOrder(int recommendOrder) {
                this.recommendOrder = recommendOrder;
            }

            public void setIsNew(int isNew) {
                this.isNew = isNew;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setIsHot(int isHot) {
                this.isHot = isHot;
            }

            public void setHasIcon(boolean hasIcon) {
                this.hasIcon = hasIcon;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public void setHeadLine(boolean headLine) {
                this.headLine = headLine;
            }

            public void setPlayCount(int playCount) {
                this.playCount = playCount;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public void setBannerOrder(int bannerOrder) {
                this.bannerOrder = bannerOrder;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public void setRadio(RadioEntity radio) {
                this.radio = radio;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTemplate() {
                return template;
            }

            public String getTopicid() {
                return topicid;
            }

            public boolean isHasCover() {
                return hasCover;
            }

            public String getAlias() {
                return alias;
            }

            public String getSubnum() {
                return subnum;
            }

            public int getRecommendOrder() {
                return recommendOrder;
            }

            public int getIsNew() {
                return isNew;
            }

            public String getImg() {
                return img;
            }

            public int getIsHot() {
                return isHot;
            }

            public boolean isHasIcon() {
                return hasIcon;
            }

            public String getCid() {
                return cid;
            }

            public String getRecommend() {
                return recommend;
            }

            public boolean isHeadLine() {
                return headLine;
            }

            public int getPlayCount() {
                return playCount;
            }

            public String getColor() {
                return color;
            }

            public int getBannerOrder() {
                return bannerOrder;
            }

            public String getTname() {
                return tname;
            }

            public String getEname() {
                return ename;
            }

            public RadioEntity getRadio() {
                return radio;
            }

            public String getShowType() {
                return showType;
            }

            public String getTid() {
                return tid;
            }

            public static class RadioEntity {
                private String postid;
                private boolean hasCover;
                private int hasHead;
                private int replyCount;
                private String ltitle;
                private int hasImg;
                private String digest;
                private boolean hasIcon;
                private String docid;
                private String title;
                private String TAGS;
                private int order;
                private int priority;
                private String lmodify;
                private String boardid;
                private String TAG;
                private String url_3w;
                private String template;
                private int votecount;
                private String alias;
                private String cid;
                private String url;
                private String size;
                private int hasAD;
                private String source;
                private String ename;
                private String tname;
                private String subtitle;
                private String imgsrc;
                private String ptime;

                public void setPostid(String postid) {
                    this.postid = postid;
                }

                public void setHasCover(boolean hasCover) {
                    this.hasCover = hasCover;
                }

                public void setHasHead(int hasHead) {
                    this.hasHead = hasHead;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public void setLtitle(String ltitle) {
                    this.ltitle = ltitle;
                }

                public void setHasImg(int hasImg) {
                    this.hasImg = hasImg;
                }

                public void setDigest(String digest) {
                    this.digest = digest;
                }

                public void setHasIcon(boolean hasIcon) {
                    this.hasIcon = hasIcon;
                }

                public void setDocid(String docid) {
                    this.docid = docid;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setTAGS(String TAGS) {
                    this.TAGS = TAGS;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public void setPriority(int priority) {
                    this.priority = priority;
                }

                public void setLmodify(String lmodify) {
                    this.lmodify = lmodify;
                }

                public void setBoardid(String boardid) {
                    this.boardid = boardid;
                }

                public void setTAG(String TAG) {
                    this.TAG = TAG;
                }

                public void setUrl_3w(String url_3w) {
                    this.url_3w = url_3w;
                }

                public void setTemplate(String template) {
                    this.template = template;
                }

                public void setVotecount(int votecount) {
                    this.votecount = votecount;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public void setCid(String cid) {
                    this.cid = cid;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public void setHasAD(int hasAD) {
                    this.hasAD = hasAD;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public void setEname(String ename) {
                    this.ename = ename;
                }

                public void setTname(String tname) {
                    this.tname = tname;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public void setImgsrc(String imgsrc) {
                    this.imgsrc = imgsrc;
                }

                public void setPtime(String ptime) {
                    this.ptime = ptime;
                }

                public String getPostid() {
                    return postid;
                }

                public boolean isHasCover() {
                    return hasCover;
                }

                public int getHasHead() {
                    return hasHead;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public String getLtitle() {
                    return ltitle;
                }

                public int getHasImg() {
                    return hasImg;
                }

                public String getDigest() {
                    return digest;
                }

                public boolean isHasIcon() {
                    return hasIcon;
                }

                public String getDocid() {
                    return docid;
                }

                public String getTitle() {
                    return title;
                }

                public String getTAGS() {
                    return TAGS;
                }

                public int getOrder() {
                    return order;
                }

                public int getPriority() {
                    return priority;
                }

                public String getLmodify() {
                    return lmodify;
                }

                public String getBoardid() {
                    return boardid;
                }

                public String getTAG() {
                    return TAG;
                }

                public String getUrl_3w() {
                    return url_3w;
                }

                public String getTemplate() {
                    return template;
                }

                public int getVotecount() {
                    return votecount;
                }

                public String getAlias() {
                    return alias;
                }

                public String getCid() {
                    return cid;
                }

                public String getUrl() {
                    return url;
                }

                public String getSize() {
                    return size;
                }

                public int getHasAD() {
                    return hasAD;
                }

                public String getSource() {
                    return source;
                }

                public String getEname() {
                    return ename;
                }

                public String getTname() {
                    return tname;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public String getImgsrc() {
                    return imgsrc;
                }

                public String getPtime() {
                    return ptime;
                }
            }
        }
    }
}
