import {createStore} from 'vuex'

const store = createStore({
    state() {
        return {
            account: {
                id: 0
            },
            info: {
                id: 0
            },
            application: {
                id: 0
            }
        }
    },
    mutations: {
        setAccount(state,payload) {
            state.account.id=payload;
        },
        setInfo(state,payload) {
            state.info.id=payload;
        },
        setApplication(state,payload) {
            state.application.id=payload;
        }

    }
})

export default store;