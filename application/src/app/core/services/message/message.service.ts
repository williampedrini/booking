import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {AlertSnackBarComponent} from '../../alert-snack-bar/alert-snack-bar.component';

@Injectable({
    providedIn: 'root'
})
export class MessageService {
    constructor(private snackBar: MatSnackBar) {
    }

    success(message: string) {
        this.snackBar.openFromComponent(AlertSnackBarComponent, {
            duration: 5 * 1000,
            data: {
                type: 'Success',
                messages: [message]
            }
        });
    }

    error(errorMessages: Array<string>) {
        this.snackBar.openFromComponent(AlertSnackBarComponent, {
            duration: 5 * 1000,
            data: {
                type: 'Error',
                messages: errorMessages
            }
        });
    }
}
