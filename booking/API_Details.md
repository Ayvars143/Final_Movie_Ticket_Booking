Microservice APIs
1. Movie Service:
   GET /movies: Retrieve all movies.
   GET /movies/{movieId}/theaters: Get theaters showing a specific movie.
2. Theater Service:
   GET /theaters: Retrieve all theaters.
   GET /theaters/{theaterId}/shows: Get shows for a specific theater.
   GET /theaters/{theaterId}/available-seats: Get available seats for a specific show.
3. Booking Service:
   GET /bookings/available-seats: Check available seats for a show.
   POST /bookings: Book seats for a selected show, apply discounts if applicable, and insert booking information.