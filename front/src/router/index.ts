import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'main',
    redirect: '/home',
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('@/views/home.vue'),
  },
  {
    path: '/Hfiles',
    name: 'Hfiles',
    redirect: '/HfilesVideo',
    component: () => import('@/views/H-files/H-files-index.vue'),
    children:
    [
      {
        path: '/HfilesVideo',
        name: 'HfilesVideo',
        component: () => import('@/views/H-files/HfilesVideo.vue')
      },
      {
        path: '/HfilesComic',
        name: 'HfilesComic',
        component: () => import('@/views/H-files/HfilesComic.vue')
      },
      {
        path: '/HfilesPicture',
        name: 'HfilesPicture',
        component: () => import('@/views/H-files/HfilesPicture.vue')
      },
      {
        path: '/HfilesPackage',
        name: 'HfilesPackage',
        component: () => import('@/views/H-files/HfilesPackage.vue')
      },
    ]
  },
  {
    path: '/HfilesVideoPlayer',
    name: 'HfilesVideoPlayer',
    component: () => import('@/views/H-files/HfilesVideoPlayer.vue')
  },
  {
    path: '/HfilesComicReader',
    name: 'HfilesComicReader',
    component: () => import('@/views/H-files/HfilesComicReader.vue')
  },
  {
    path: '/Manage',
    name: 'Manage',
    redirect: '/Usermanage',
    component: () => import('@/views/manage/ManageIndex.vue'),
    children:
    [
      {
        path: '/UserManage',
        name: 'UserManage',
        component: () => import('@/views/manage/UserManage.vue'),
      }
    ]
  },
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
