import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { User } from "../models/user";

@Injectable({
  providedIn: "root",
})
export class InputService {
  private inputData = new BehaviorSubject<User>(undefined);

  constructor() {}

  setUser(user: User) {
    this.inputData.next(user);
  }

  getUser(): Observable<User> {
    return this.inputData.asObservable();
  }
}
