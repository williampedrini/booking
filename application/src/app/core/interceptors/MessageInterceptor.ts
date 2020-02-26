import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {MessageService} from '../services/message/message.service';

@Injectable()
export class MessageInterceptor implements HttpInterceptor {

    constructor(private messageService: MessageService) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError((err) => {
            const error = err.error.messages[0];
            this.messageService.error(error);
            return throwError(error);
        }));
    }
}
