package com.yi.ziyue.beans;

import java.util.List;

/**
 * Created by Yi on 16/3/8.
 */
public class NewsListBeans {


    /**
     * postid : PHOT3DTR000100AP
     * hasCover : false
     * hasHead : 1
     * replyCount : 3457
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_BHKIF00UliushuqiupdateDoc
     * title : 哈尔滨水管泄漏车被冻 如"冰河世纪"
     * order : 1
     * priority : 252
     * lmodify : 2016-03-08 09:39:47
     * boardid : photoview_bbs
     * ads : [{"title":"《看客》：\u201c买\u201d妻村庄里的寂寞留民","tag":"photoset","imgsrc":"http://img3.cache.netease.com/3g/2016/3/8/20160308084155957b4.jpg","subtitle":"","url":"3R710001|112539"},{"title":"外交部长就\"外交政策和对外关系\"答问","tag":"photoset","imgsrc":"http://img6.cache.netease.com/3g/2016/3/8/20160308103642dea09.jpg","subtitle":"","url":"00AN0001|112579"},{"title":"三八节丈夫甘做\"出气筒\" 请妻子解气","tag":"photoset","imgsrc":"http://img4.cache.netease.com/3g/2016/3/8/20160308074525ec545.jpg","subtitle":"","url":"00AP0001|112554"},{"title":"葛存壮追悼会举行 影迷叩头送别","tag":"photoset","imgsrc":"http://img6.cache.netease.com/3g/2016/3/8/20160308094716a5464.jpg","subtitle":"","url":"00AP0001|112570"},{"title":"潘基文获\"德国媒体奖\" 谈及难民问题","tag":"photoset","imgsrc":"http://img4.cache.netease.com/3g/2016/3/8/20160308080422d9d85.jpg","subtitle":"","url":"00AO0001|112561"}]
     * photosetID : 00AP0001|112571
     * template : manual
     * votecount : 2843
     * skipID : 00AP0001|112571
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://img5.cache.netease.com/3g/2016/3/8/2016030809404596e1d.jpg"},{"imgsrc":"http://img1.cache.netease.com/3g/2016/3/8/2016030809404793d3d.jpg"}]
     * ename : androidnews
     * tname : 头条
     * imgsrc : http://img5.cache.netease.com/3g/2016/3/8/2016030809414995cc2.jpg
     * ptime : 2016-03-08 09:39:47
     */




        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        /**
         * title : 《看客》：“买”妻村庄里的寂寞留民
         * tag : photoset
         * imgsrc : http://img3.cache.netease.com/3g/2016/3/8/20160308084155957b4.jpg
         * subtitle :
         * url : 3R710001|112539
         */

        private List<AdsEntity> ads;
        /**
         * imgsrc : http://img5.cache.netease.com/3g/2016/3/8/2016030809404596e1d.jpg
         */

        private List<ImgextraEntity> imgextra;

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

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setAds(List<AdsEntity> ads) {
            this.ads = ads;
        }

        public void setImgextra(List<ImgextraEntity> imgextra) {
            this.imgextra = imgextra;
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

        public String getPhotosetID() {
            return photosetID;
        }

        public String getTemplate() {
            return template;
        }

        public int getVotecount() {
            return votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public String getAlias() {
            return alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public String getCid() {
            return cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public String getEname() {
            return ename;
        }

        public String getTname() {
            return tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public List<AdsEntity> getAds() {
            return ads;
        }

        public List<ImgextraEntity> getImgextra() {
            return imgextra;
        }

        public static class AdsEntity {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public String getTag() {
                return tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public String getUrl() {
                return url;
            }
        }

        public static class ImgextraEntity {
            private String imgsrc;

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getImgsrc() {
                return imgsrc;
            }
        }
    }

