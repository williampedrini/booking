import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
    providedIn: 'root'
})
export class MessageService {
    constructor(private snackBar: MatSnackBar) {
    }

    success(message: string) {
        this.snackBar.open(message, 'success', {
            duration: 5 * 1000
        });
    }

    error(message: string) {
        this.snackBar.open(message, 'error', {
            duration: 5 * 1000
        });
    }
}
