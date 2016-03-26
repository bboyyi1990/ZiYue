package com.yi.ziyue.beans;

import java.util.List;

/**
 * Created by Yi on 16/3/21.
 */
public class WeatherBeans {


    /**
     * city : {"aqi":"121","co":"2","no2":"84","o3":"56","pm10":"142","pm25":"91","qlty":"轻度污染","so2":"124"}
     */

    private AqiEntity aqi;
    /**
     * city : 大连
     * cnty : 中国
     * id : CN101070201
     * lat : 38.944000
     * lon : 121.576000
     * update : {"loc":"2016-03-21 10:49","utc":"2016-03-21 02:49"}
     */

    private BasicEntity basic;
    /**
     * cond : {"code":"101","txt":"多云"}
     * fl : 16
     * hum : 23
     * pcpn : 0
     * pres : 1024
     * tmp : 13
     * vis : 7
     * wind : {"deg":"277","dir":"南风","sc":"4-5","spd":"22"}
     */

    private NowEntity now;
    /**
     * aqi : {"city":{"aqi":"121","co":"2","no2":"84","o3":"56","pm10":"142","pm25":"91","qlty":"轻度污染","so2":"124"}}
     * basic : {"city":"大连","cnty":"中国","id":"CN101070201","lat":"38.944000","lon":"121.576000","update":{"loc":"2016-03-21 10:49","utc":"2016-03-21 02:49"}}
     * daily_forecast : [{"astro":{"sr":"05:54","ss":"18:06"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-03-21","hum":"41","pcpn":"0.0","pop":"0","pres":"1023","tmp":{"max":"13","min":"5"},"vis":"10","wind":{"deg":"247","dir":"西南风","sc":"4-5","spd":"18"}},{"astro":{"sr":"05:53","ss":"18:07"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-03-22","hum":"46","pcpn":"0.0","pop":"0","pres":"1021","tmp":{"max":"11","min":"2"},"vis":"10","wind":{"deg":"11","dir":"北风","sc":"4-5","spd":"22"}},{"astro":{"sr":"05:51","ss":"18:08"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-23","hum":"44","pcpn":"0.0","pop":"0","pres":"1030","tmp":{"max":"7","min":"1"},"vis":"10","wind":{"deg":"337","dir":"北风","sc":"5-6","spd":"25"}},{"astro":{"sr":"05:50","ss":"18:09"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-24","hum":"40","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"7","min":"3"},"vis":"10","wind":{"deg":"339","dir":"北风","sc":"4-5","spd":"19"}},{"astro":{"sr":"05:48","ss":"18:10"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-25","hum":"38","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"10","min":"4"},"vis":"10","wind":{"deg":"312","dir":"北风","sc":"4-5","spd":"18"}},{"astro":{"sr":"05:47","ss":"18:11"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-26","hum":"40","pcpn":"0.0","pop":"0","pres":"1022","tmp":{"max":"11","min":"5"},"vis":"10","wind":{"deg":"275","dir":"西南风","sc":"4-5","spd":"22"}},{"astro":{"sr":"05:45","ss":"18:12"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-03-27","hum":"42","pcpn":"0.0","pop":"0","pres":"1023","tmp":{"max":"13","min":"7"},"vis":"10","wind":{"deg":"242","dir":"南风","sc":"4-5","spd":"18"}}]
     * hourly_forecast : [{"date":"2016-03-21 10:00","hum":"46","pop":"0","pres":"1025","tmp":"14","wind":{"deg":"261","dir":"西风","sc":"微风","spd":"12"}},{"date":"2016-03-21 13:00","hum":"42","pop":"0","pres":"1024","tmp":"14","wind":{"deg":"251","dir":"西南风","sc":"3-4","spd":"18"}},{"date":"2016-03-21 16:00","hum":"43","pop":"0","pres":"1022","tmp":"13","wind":{"deg":"250","dir":"西南风","sc":"3-4","spd":"20"}},{"date":"2016-03-21 19:00","hum":"47","pop":"0","pres":"1021","tmp":"11","wind":{"deg":"240","dir":"西南风","sc":"微风","spd":"16"}},{"date":"2016-03-21 22:00","hum":"51","pop":"0","pres":"1020","tmp":"10","wind":{"deg":"223","dir":"西南风","sc":"3-4","spd":"19"}}]
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"16","hum":"23","pcpn":"0","pres":"1024","tmp":"13","vis":"7","wind":{"deg":"277","dir":"南风","sc":"4-5","spd":"22"}}
     * status : ok
     * suggestion : {"comf":{"brf":"较舒适","txt":"白天天气晴好但风力较强，早晚会感觉偏凉，午后舒适、宜人。"},"cw":{"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"易发","txt":"昼夜温差大，风力较强，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"},"sport":{"brf":"较不宜","txt":"天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"},"trav":{"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
     */

    private String status;
    /**
     * comf : {"brf":"较舒适","txt":"白天天气晴好但风力较强，早晚会感觉偏凉，午后舒适、宜人。"}
     * cw : {"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"}
     * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
     * flu : {"brf":"易发","txt":"昼夜温差大，风力较强，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"}
     * sport : {"brf":"较不宜","txt":"天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"}
     * trav : {"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"}
     * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
     */

    private SuggestionEntity suggestion;
    /**
     * astro : {"sr":"05:54","ss":"18:06"}
     * cond : {"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"}
     * date : 2016-03-21
     * hum : 41
     * pcpn : 0.0
     * pop : 0
     * pres : 1023
     * tmp : {"max":"13","min":"5"}
     * vis : 10
     * wind : {"deg":"247","dir":"西南风","sc":"4-5","spd":"18"}
     */

    private List<DailyForecastEntity> daily_forecast;
    /**
     * date : 2016-03-21 10:00
     * hum : 46
     * pop : 0
     * pres : 1025
     * tmp : 14
     * wind : {"deg":"261","dir":"西风","sc":"微风","spd":"12"}
     */

    private List<HourlyForecastEntity> hourly_forecast;

    public void setAqi(AqiEntity aqi) {
        this.aqi = aqi;
    }

    public void setBasic(BasicEntity basic) {
        this.basic = basic;
    }

    public void setNow(NowEntity now) {
        this.now = now;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSuggestion(SuggestionEntity suggestion) {
        this.suggestion = suggestion;
    }

    public void setDaily_forecast(List<DailyForecastEntity> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastEntity> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public AqiEntity getAqi() {
        return aqi;
    }

    public BasicEntity getBasic() {
        return basic;
    }

    public NowEntity getNow() {
        return now;
    }

    public String getStatus() {
        return status;
    }

    public SuggestionEntity getSuggestion() {
        return suggestion;
    }

    public List<DailyForecastEntity> getDaily_forecast() {
        return daily_forecast;
    }

    public List<HourlyForecastEntity> getHourly_forecast() {
        return hourly_forecast;
    }

    public static class AqiEntity {
        /**
         * aqi : 121
         * co : 2
         * no2 : 84
         * o3 : 56
         * pm10 : 142
         * pm25 : 91
         * qlty : 轻度污染
         * so2 : 124
         */

        private CityEntity city;

        public void setCity(CityEntity city) {
            this.city = city;
        }

        public CityEntity getCity() {
            return city;
        }

        public static class CityEntity {
            private String aqi;
            private String co;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String qlty;
            private String so2;

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getAqi() {
                return aqi;
            }

            public String getCo() {
                return co;
            }

            public String getNo2() {
                return no2;
            }

            public String getO3() {
                return o3;
            }

            public String getPm10() {
                return pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public String getQlty() {
                return qlty;
            }

            public String getSo2() {
                return so2;
            }
        }
    }

    public static class BasicEntity {
        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        /**
         * loc : 2016-03-21 10:49
         * utc : 2016-03-21 02:49
         */

        private UpdateEntity update;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public void setUpdate(UpdateEntity update) {
            this.update = update;
        }

        public String getCity() {
            return city;
        }

        public String getCnty() {
            return cnty;
        }

        public String getId() {
            return id;
        }

        public String getLat() {
            return lat;
        }

        public String getLon() {
            return lon;
        }

        public UpdateEntity getUpdate() {
            return update;
        }

        public static class UpdateEntity {
            private String loc;
            private String utc;

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }

            public String getLoc() {
                return loc;
            }

            public String getUtc() {
                return utc;
            }
        }
    }

    public static class NowEntity {
        /**
         * code : 101
         * txt : 多云
         */

        private CondEntity cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        /**
         * deg : 277
         * dir : 南风
         * sc : 4-5
         * spd : 22
         */

        private WindEntity wind;

        public void setCond(CondEntity cond) {
            this.cond = cond;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public void setWind(WindEntity wind) {
            this.wind = wind;
        }

        public CondEntity getCond() {
            return cond;
        }

        public String getFl() {
            return fl;
        }

        public String getHum() {
            return hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public String getPres() {
            return pres;
        }

        public String getTmp() {
            return tmp;
        }

        public String getVis() {
            return vis;
        }

        public WindEntity getWind() {
            return wind;
        }

        public static class CondEntity {
            private String code;
            private String txt;

            public void setCode(String code) {
                this.code = code;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getCode() {
                return code;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class WindEntity {
            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }

            public String getDeg() {
                return deg;
            }

            public String getDir() {
                return dir;
            }

            public String getSc() {
                return sc;
            }

            public String getSpd() {
                return spd;
            }
        }
    }

    public static class SuggestionEntity {
        /**
         * brf : 较舒适
         * txt : 白天天气晴好但风力较强，早晚会感觉偏凉，午后舒适、宜人。
         */

        private ComfEntity comf;
        /**
         * brf : 较不宜
         * txt : 较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。
         */

        private CwEntity cw;
        /**
         * brf : 较冷
         * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
         */

        private DrsgEntity drsg;
        /**
         * brf : 易发
         * txt : 昼夜温差大，风力较强，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
         */

        private FluEntity flu;
        /**
         * brf : 较不宜
         * txt : 天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。
         */

        private SportEntity sport;
        /**
         * brf : 适宜
         * txt : 天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。
         */

        private TravEntity trav;
        /**
         * brf : 中等
         * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
         */

        private UvEntity uv;

        public void setComf(ComfEntity comf) {
            this.comf = comf;
        }

        public void setCw(CwEntity cw) {
            this.cw = cw;
        }

        public void setDrsg(DrsgEntity drsg) {
            this.drsg = drsg;
        }

        public void setFlu(FluEntity flu) {
            this.flu = flu;
        }

        public void setSport(SportEntity sport) {
            this.sport = sport;
        }

        public void setTrav(TravEntity trav) {
            this.trav = trav;
        }

        public void setUv(UvEntity uv) {
            this.uv = uv;
        }

        public ComfEntity getComf() {
            return comf;
        }

        public CwEntity getCw() {
            return cw;
        }

        public DrsgEntity getDrsg() {
            return drsg;
        }

        public FluEntity getFlu() {
            return flu;
        }

        public SportEntity getSport() {
            return sport;
        }

        public TravEntity getTrav() {
            return trav;
        }

        public UvEntity getUv() {
            return uv;
        }

        public static class ComfEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class CwEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class DrsgEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class FluEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class SportEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class TravEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }

        public static class UvEntity {
            private String brf;
            private String txt;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }
        }
    }

    public static class DailyForecastEntity {
        /**
         * sr : 05:54
         * ss : 18:06
         */

        private AstroEntity astro;
        /**
         * code_d : 100
         * code_n : 101
         * txt_d : 晴
         * txt_n : 多云
         */

        private CondEntity cond;
        private String date;
        private String hum;
        private String pcpn;
        private String pop;
        private String pres;
        /**
         * max : 13
         * min : 5
         */

        private TmpEntity tmp;
        private String vis;
        /**
         * deg : 247
         * dir : 西南风
         * sc : 4-5
         * spd : 18
         */

        private WindEntity wind;

        public void setAstro(AstroEntity astro) {
            this.astro = astro;
        }

        public void setCond(CondEntity cond) {
            this.cond = cond;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public void setTmp(TmpEntity tmp) {
            this.tmp = tmp;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public void setWind(WindEntity wind) {
            this.wind = wind;
        }

        public AstroEntity getAstro() {
            return astro;
        }

        public CondEntity getCond() {
            return cond;
        }

        public String getDate() {
            return date;
        }

        public String getHum() {
            return hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public String getPop() {
            return pop;
        }

        public String getPres() {
            return pres;
        }

        public TmpEntity getTmp() {
            return tmp;
        }

        public String getVis() {
            return vis;
        }

        public WindEntity getWind() {
            return wind;
        }

        public static class AstroEntity {
            private String sr;
            private String ss;

            public void setSr(String sr) {
                this.sr = sr;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getSr() {
                return sr;
            }

            public String getSs() {
                return ss;
            }
        }

        public static class CondEntity {
            private String code_d;
            private String code_n;
            private String txt_d;
            private String txt_n;

            public void setCode_d(String code_d) {
                this.code_d = code_d;
            }

            public void setCode_n(String code_n) {
                this.code_n = code_n;
            }

            public void setTxt_d(String txt_d) {
                this.txt_d = txt_d;
            }

            public void setTxt_n(String txt_n) {
                this.txt_n = txt_n;
            }

            public String getCode_d() {
                return code_d;
            }

            public String getCode_n() {
                return code_n;
            }

            public String getTxt_d() {
                return txt_d;
            }

            public String getTxt_n() {
                return txt_n;
            }
        }

        public static class TmpEntity {
            private String max;
            private String min;

            public void setMax(String max) {
                this.max = max;
            }

            public void setMin(String min) {
                this.min = min;
            }

            public String getMax() {
                return max;
            }

            public String getMin() {
                return min;
            }
        }

        public static class WindEntity {
            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }

            public String getDeg() {
                return deg;
            }

            public String getDir() {
                return dir;
            }

            public String getSc() {
                return sc;
            }

            public String getSpd() {
                return spd;
            }
        }
    }

    public static class HourlyForecastEntity {
        private String date;
        private String hum;
        private String pop;
        private String pres;
        private String tmp;
        /**
         * deg : 261
         * dir : 西风
         * sc : 微风
         * spd : 12
         */

        private WindEntity wind;

        public void setDate(String date) {
            this.date = date;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public void setWind(WindEntity wind) {
            this.wind = wind;
        }

        public String getDate() {
            return date;
        }

        public String getHum() {
            return hum;
        }

        public String getPop() {
            return pop;
        }

        public String getPres() {
            return pres;
        }

        public String getTmp() {
            return tmp;
        }

        public WindEntity getWind() {
            return wind;
        }

        public static class WindEntity {
            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }

            public String getDeg() {
                return deg;
            }

            public String getDir() {
                return dir;
            }

            public String getSc() {
                return sc;
            }

            public String getSpd() {
                return spd;
            }
        }
    }
}
