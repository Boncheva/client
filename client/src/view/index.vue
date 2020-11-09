<template>
    <el-container>
        <el-header>
            <v-header></v-header>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <v-aside></v-aside>
            </el-aside>
            <el-container>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </el-container>
</template>

<script>
    import VHeader from './header.vue'
    import VAside from './aside.vue'

    export default {
        name: "index",
        components: {
            VHeader,
            VAside
        },
    }
</script>

<style lang="scss">
    .body-wrap {
        .right-wrap {
            flex: 1;
            display: flex;
            flex: 1;

            .left-wrap {
                flex: none;
                width: 200px;
            }

            .content-wrap {
                flex: 1;
                padding: 10px;
                box-sizing: border-box;

                .content-body {
                    background: #ccc;
                }
            }
        }
    }
</style>