package com.example.once2.model.Json;

import java.util.List;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/6 18:40
 */
public class CloudJson {
    private String code;
    private dataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public dataBean getData() {
        return data;
    }

    public void setData(dataBean data) {
        this.data = data;
    }

    public static class dataBean{
        private String city;
        private String weather;
        private String date;
        private String weather_code;
        private String temp;
        private String min_temp;
        private String max_temp;
        private String sunrise;
        private String sunset;
        private api apiData;
        private List<hour> hourData;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeather_code() {
            return weather_code;
        }

        public void setWeather_code(String weather_code) {
            this.weather_code = weather_code;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getMin_temp() {
            return min_temp;
        }

        public void setMin_temp(String min_temp) {
            this.min_temp = min_temp;
        }

        public String getMax_temp() {
            return max_temp;
        }

        public void setMax_temp(String max_temp) {
            this.max_temp = max_temp;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public api getApiData() {
            return apiData;
        }

        public void setApiData(api apiData) {
            this.apiData = apiData;
        }

        public List<hour> getHourData() {
            return hourData;
        }

        public void setHourData(List<hour> hourData) {
            this.hourData = hourData;
        }

        public static class api{
            private String air;
            private String air_level;
            private String air_tips;

            public String getAir() {
                return air;
            }

            public void setAir(String air) {
                this.air = air;
            }

            public String getAir_level() {
                return air_level;
            }

            public void setAir_level(String air_level) {
                this.air_level = air_level;
            }

            public String getAir_tips() {
                return air_tips;
            }

            public void setAir_tips(String air_tips) {
                this.air_tips = air_tips;
            }
        }
        public static class hour{
            private String time;
            private String temp;
            private String wea;
            private String wind;
            private String wind_level;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWea() {
                return wea;
            }

            public void setWea(String wea) {
                this.wea = wea;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWind_level() {
                return wind_level;
            }

            public void setWind_level(String wind_level) {
                this.wind_level = wind_level;
            }
        }
    }
}
