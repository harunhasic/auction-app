import { decode } from "jsonwebtoken";

export function setSession(user, token) {
    localStorage.setItem('auctionapp-user', JSON.stringify(user));
    localStorage.setItem('auctionapp-token', token);
}

export function removeSession() {
    localStorage.removeItem('auctionapp-token');
    localStorage.removeItem('auctionapp-user');
};

export function getUserId() {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user).id : null;
};

export function getUser() {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user) : null;
};

export function saveUser(user) {
    localStorage.setItem('auctionapp-user', JSON.stringify(user));
}

export function getToken() {
    return localStorage.getItem('auctionapp-token') || null;
}

export function isTokenValid() {
    const token = getToken();
    if (token === null)
        return false;
    const exp = decode(token, { complete: true }).payload.exp;
    return Date.now() < exp * 1000;
}
