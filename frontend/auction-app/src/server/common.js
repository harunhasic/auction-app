import { getToken } from '../utils/LocalStorageUtils';


export function defaultHeader() {
    return {
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    };
}

export function getParams(args) {
    return {
        params: {
            ...args
        }
    };
}