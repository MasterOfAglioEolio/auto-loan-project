import {createStore} from 'vuex'

const store = createStore({
    state() {
        return {
            account: {
                id: 0
            },
            accountId:{
                id:''
            },
            info: {
                id: 0
            },
            application: {
                id: 0
            },
            large_Mode:{
                check:0
            }

        }
    },
    mutations: {
        setAccount(state,payload) {
            state.account.id=payload;
        },
        setAccountId(state,accountId){
            state.accountId.id=accountId;
        },
        setInfo(state,payload) {
            state.info.id=payload;
        },
        setApplication(state,payload) {
            state.application.id=payload;
        },
        setLargeMode(state,payload) {
            state.large_Mode.check=payload;
        }



    }
})

export default store;