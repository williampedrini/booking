import TripWayPoint from './TripWayPoint';

export default class Booking {
    public bookingId: string;
    public passengerName: string;
    public passengerContactNumber: string;
    public pickupTime: Date = new Date();
    public asap: boolean = true;
    public waitingTime: number;
    public noOfPassengers: number;
    public price: number;
    public rating: number;
    public createdOn: Date;
    public hasModifiedOn: Date;
    public tripWayPoints: TripWayPoint[] = [];
}
