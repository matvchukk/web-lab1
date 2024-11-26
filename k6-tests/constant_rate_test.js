import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.1.0/index.js';

export let options = {
    scenarios: {
        ramping_load: {
            executor: 'ramping-vus',
            startVUs: 0, // початкова кількість користувачів
            stages: [
                { duration: '2m', target: 20 }, // підвищення до 20 користувачів
                { duration: '3m', target: 50 }, // підвищення до 50 користувачів
                { duration: '2m', target: 0 }, // зниження до 0 користувачів
            ],
        },
    },
};

export default function () {
    const productId = randomIntBetween(1, 1000);
    const timeout = randomIntBetween(1, 100);
    const url = `http://localhost:8080/products/${productId}?timeout=${timeout}`;

    const res = http.get(url);
    check(res, {
        'status is 200': (r) => r.status === 200,
    });

    sleep(randomIntBetween(1, 3));
}
