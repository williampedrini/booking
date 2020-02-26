import TripWayPoint from './TripWayPoint';

export default class BookingAddRequest {
    constructor(
        public passengerName,
        public passengerContactNumber,
        public pickupTime: Date = new Date(),
        public asap = true,
        public waitingTime: number,
        public noOfPassengers: number,
        public price: number,
        public rating: number,
        public tripWayPoints: Array<TripWayPoint>
    ) {
    }
}
