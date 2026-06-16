import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Stream } from '../models/stream.model';

@Injectable({
  providedIn: 'root',
})
export class StreamService {
  private readonly apiUrl = '/api/streams';

  constructor(private readonly http: HttpClient) {}

  getLiveStreams(): Observable<Stream[]> {
    return this.http.get<Stream[]>(this.apiUrl);
  }
}
