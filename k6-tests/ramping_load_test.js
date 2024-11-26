import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.1.0/index.js';

export let options = {
    scenarios: {
        constant_rate: {
            executor: 'constant-arrival-rate',
            rate: 20, // кількість запитів за секунду
            timeUnit: '1s',
            duration: '5m',
            preAllocatedVUs: 50, // максимальна кількість користувачів
            maxVUs: 100,
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

    sleep(randomIntBetween(1, 3)); // Випадкова затримка від 1 до 3 секунд
}
