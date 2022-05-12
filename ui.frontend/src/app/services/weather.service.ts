import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { Location } from 'src/app/models/location';
import { Weather } from 'src/app/models/weather';

const URL_OPEN_WEATHER = 'http://api.openweathermap.org/data/2.5/weather';
const URL_OPEN_WEATHER_ICON = 'http://openweathermap.org/img/w';

@Injectable({
    providedIn: 'root',
})
export class WeatherService {
    constructor(private http: HttpClient) {}

    getWeather(): Observable<Weather> {
        const location: Location = {
            lat: -30.0331,
            lon: -51.23,
            appid: 'e35fda9eb8f4d08d4e8919a4ab0a2140',
            lang: 'pt',
            units: 'metric',
        };

        return this.http
            .get<Weather>(URL_OPEN_WEATHER, {
                params: {
                    lat: location.lat.toString(),
                    lon: location.lon.toString(),
                    appid: location.appid,
                    lang: location.lang,
                    units: location.units,
                },
            })
            .pipe(
                map((res: any) => {
                    const weather: Weather = {
                        location: `${res.name} - RS`,
                        temperature: `${res.main.temp.toFixed(0)}°`,
                        imageSrc: this.getWeatherIcon(
                            `${res.weather[0].icon}.png`
                        ),
                    };
                    return weather;
                })
            );
    }

    getWeatherIcon(icon: string): string {
        return `${URL_OPEN_WEATHER_ICON}/${icon}`;
    }
}