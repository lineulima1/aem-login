import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class LocalStorageService {
  constructor() {}

  add(key: string, value: string): void {
    localStorage.setItem(key, value);
  }

  remove(key: string): void {
    localStorage.removeItem(key);
  }

  get(key: string): string {
    return localStorage.getItem(key);
  }

  clear(): void {
    localStorage.clear();
  }
}
